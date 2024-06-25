<template>
    <ContentFiled>
        <div class="fa">
            <div v-for="book in books" :key="book.id" class="card card1" style="width: 18rem;">
                <img :src="book.photo" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">《{{ book.title }}》</h5>
                    <p class="card-text">作者：{{ book.author }}</p>
                    <p class="card-text">价格：{{ book.price }}</p>
                    <p class="card-text">数量：{{ book.count }}</p>
                    <button type="button" class="btn btn-primary btn1" data-bs-toggle="modal"
                        :data-bs-target="'#book_btn-' + book.id">购买</button>
                    <!-- Modal -->
                    <div class="modal fade " :id="'book_btn-' + book.id" data-bs-backdrop="static"
                        data-bs-keyboard="false" tabindex="-1">
                        <div class="modal-dialog modal-lg">
                            <div class=" modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="staticBackdropLabel">要买的书</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="d-grid gap-3">
                                    <div style="font-weight: bolder; margin-top: 20px;">书本名字</div>
                                    <div class="p-2 bg-light border">
                                        {{ book.title }}
                                    </div>
                                    <div style="font-weight: bolder; margin-top: 20px;">书本作者</div>
                                    <div class="p-2 bg-light border">
                                        {{ book.author }}
                                    </div>
                                    <div style="font-weight: bolder; margin-top: 20px;">书本价格</div>
                                    <div class="p-2 bg-light border">
                                        {{ book.price }}
                                    </div>
                                    <div style="font-weight: bolder; margin-top: 20px;">书本数量</div>
                                    <div class="p-2 bg-light border">
                                        {{ book.title }}
                                    </div>
                                    <div style="font-weight: bolder; margin-top: 20px;">书本简介</div>
                                    <div class="p-2 bg-light border" style="margin-top: 5px;">
                                        {{ book.description }}
                                    </div>


                                </div>
                                <div class="modal-footer">
                                    <div class="error-message">{{ book.error_message }}</div>
                                    <button type="button" class="btn btn-success btn1"
                                        @click="buy_book(book)">购买</button>
                                    <button type="button" class="btn btn-secondary btn1"
                                        data-bs-dismiss="modal">关闭</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav aria-label="...">
            <ul class="pagination" style="float: right; margin-top: 20px;">
                <li class="page-item" @click="click_page(-2)">
                    <a class="page-link" href="#">前一页</a>
                </li>
                <li :class="'page-item ' + page.is_active" v-for="page in pages" :key="page.number"
                    @click="click_page(page.number)"><a class="page-link" href="#">{{ page.number }}</a></li>
                <li class="page-item" @click="click_page(-1)">
                    <a class="page-link" href="#">下一页</a>
                </li>
            </ul>
        </nav>
    </ContentFiled>
</template>

<script>
import ContentFiled from '@/components/ContentField'
import { useStore } from 'vuex'
import $ from 'jquery'
import { ref } from 'vue'
import { Modal } from 'bootstrap/dist/js/bootstrap'

export default {
    components: {
        ContentFiled,
    },

    setup() {
        const store = useStore();
        let current_page = 1;
        let books = ref([]);
        let total_books = 0;
        let pages = ref([]);


        const update_pages = () => {
            let max_pages = parseInt(Math.ceil(total_books / 12));
            let new_pages = [];
            for(let i = current_page - 2; i <= current_page + 2; i++) {
                if(i >= 1 && i <= max_pages) {
                    new_pages.push({
                        number: i,
                        is_active: i === current_page ? "active" : "",
                    });
                }
            }
            pages.value = new_pages;
        }

        const click_page = page => {
            if(page === -2) page = current_page - 1;
            else if(page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_books / 12));

            if(page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://localhost:3020/buy/getbook/",
                type: "get",
                data: {
                    page,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    books.value = resp.books;
                    total_books = resp.books_count;
                    update_pages();
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }

        const buy_book = (book) => {
            book.error_message = "";
            $.ajax({
                url: "http://localhost:3020/buy/buybook/",
                type: "post",
                data: {
                    book_id: book.id,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if(resp.error_message === "success") {
                        pull_page(current_page);
                        Modal.getInstance("#book_btn-" + + book.id).hide();
                    } else {
                        book.error_message = resp.error_message;
                    }
                },
                error(resp) {
                    console.log(resp);
                }
            })

        }
        pull_page(current_page);

        return {
            books,
            pages,
            click_page,
            buy_book
        }

    }
}
</script>
<style scoped>
.card-text {
    margin-left: 10px;
}
.fa {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
.card1 {
    margin-right: 20px;
    margin-top: 20px;
}
.btn1 {
    width: 100%;
}
.error-message {
    color: red;
}

</style>