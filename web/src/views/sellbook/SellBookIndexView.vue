<template>
    <ContentFiled>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <div class="card" style="margin-top: 20px">
                        <div class="card-body">
                            <img :src="$store.state.user.photo" alt="" style="width: 100%;">
                            <div style="font-size: large; font-weight: bolder; text-align: center;">{{
                                $store.state.user.name }}</div>
                        </div>
                    </div>
                </div>
                <div class="col-9">
                    <div class="card" style="margin-top: 20px;">
                        <div class="card-header">
                            <span style="font-size: 140%;"> 我在卖的书</span>
                            <button type="submit" class="btn btn-success float-end" data-bs-toggle="modal"
                                data-bs-target="#add_book_btn">卖书</button>
                            <!-- Modal -->
                            <div class="modal fade " id="add_book_btn" data-bs-backdrop="static"
                                data-bs-keyboard="false" tabindex="-1">
                                <div class="modal-dialog modal-lg">
                                    <div class=" modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">要卖的书</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                <label for="add-book-title" class="form-label">书本名字</label>
                                                <input v-model="bookadd.title" type="text" class="form-control"
                                                    id="add-book-title" placeholder="请输入书的名字">
                                            </div>
                                            <div class="mb-3">
                                                <label for="add-book-author" class="form-label">作者名字</label>
                                                <input v-model="bookadd.author" type="text" class="form-control"
                                                    id="add-book-author" placeholder="请输入作者名字">
                                            </div>
                                            <div class="mb-3">
                                                <label for="add-book-price" class="form-label">书本价格</label>
                                                <input v-model="bookadd.price" type="text" class="form-control"
                                                    id="add-book-price" placeholder="请输入书的名价格">
                                            </div>
                                            <div class="mb-3">
                                                <label for="add-book-count" class="form-label">书本数量</label>
                                                <input v-model="bookadd.count" type="text" class="form-control"
                                                    id="add-book-count" placeholder="请输入书的数量">
                                            </div>
                                            <div class="mb-3">
                                                <label for="add-book-description" class="form-label">书本简介</label>
                                                <textarea v-model="bookadd.description" class="form-control"
                                                    id="add-book-description" rows="3" placeholder="请输入书的简介"></textarea>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <div class="error-message">{{ bookadd.error_message }}</div>
                                            <button type="button" class="btn btn-success" @click="add_book">发布</button>
                                            <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">关闭</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>书名</th>
                                        <th>作者</th>
                                        <th>价格</th>
                                        <th>数量</th>
                                        <th>上架时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="book in books" :key="book.id">
                                        <td>{{ book.title }}</td>
                                        <td>{{ book.author }}</td>
                                        <td>{{ book.price }}</td>
                                        <td>{{ book.count }}</td>
                                        <td>{{ book.createtime }}</td>
                                        <td>
                                            <button type="button" class="btn btn-primary" style="margin-right: 10px;"
                                                data-bs-toggle="modal"
                                                :data-bs-target="'#update_book_btn-' + book.id">修改</button>
                                            <button type="button" class="btn btn-danger"
                                                @click="remove_book(book)">删除</button>
                                            <!-- Modal -->
                                            <div class="modal fade " :id="'update_book_btn-' + book.id"
                                                data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
                                                <div class="modal-dialog modal-lg">
                                                    <div class=" modal-content">
                                                        <div class="modal-header">
                                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">要卖的书
                                                            </h1>
                                                            <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="mb-3">
                                                                <label for="add-book-title"
                                                                    class="form-label">书本名字</label>
                                                                <input v-model="book.title" type="text"
                                                                    class="form-control" id="add-book-title"
                                                                    placeholder="请输入书的名字">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="add-book-author"
                                                                    class="form-label">作者名字</label>
                                                                <input v-model="book.author" type="text"
                                                                    class="form-control" id="add-book-author"
                                                                    placeholder="请输入作者名字">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="add-book-price"
                                                                    class="form-label">书本价格</label>
                                                                <input v-model="book.price" type="text"
                                                                    class="form-control" id="add-book-price"
                                                                    placeholder="请输入书的名价格">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="add-book-count"
                                                                    class="form-label">书本数量</label>
                                                                <input v-model="book.count" type="text"
                                                                    class="form-control" id="add-book-count"
                                                                    placeholder="请输入书的数量">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="add-book-description"
                                                                    class="form-label">书本简介</label>
                                                                <textarea v-model="book.description"
                                                                    class="form-control" id="add-book-description"
                                                                    rows="3" placeholder="请输入书的简介"></textarea>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <div class="error-message">{{ book.error_message }}</div>
                                                            <button type="button" class="btn btn-success"
                                                                @click="update_book(book)">发布</button>
                                                            <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">关闭</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentFiled>
</template>

<script>
import ContentFiled from '@/components/ContentField'
import { ref,reactive } from 'vue'
import $ from 'jquery'
import { useStore } from 'vuex';
import {Modal} from 'bootstrap/dist/js/bootstrap'

export default {
    components: {
        ContentFiled,
    },
    setup() {
        const store = useStore();
        let books = ref([]);

        const bookadd = reactive({
            title: "",
            author: "",
            price: "",
            count: "",
            description: "",
            error_message: "",
        });

        const refresh_books = () => {
            $.ajax({
                url: "http://localhost:3020/user/book/getlist/",
                type:"get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    books.value = resp;
                }
            })
        };

        const remove_book = (book) => {
            $.ajax({
                url: "http://localhost:3020/user/book/remove/",
                type: "post",
                data: {
                    book_id: book.id,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if(resp.error_message === "success") {
                        refresh_books();
                    }
                }
            })
        };

        const add_book = () => {
            bookadd.error_message = "";
            $.ajax({
                url: "http://localhost:3020/user/book/add/",
                type: "post",
                data: {
                    title: bookadd.title,
                    author: bookadd.author,
                    price: bookadd.price,
                    count: bookadd.count,
                    description: bookadd.description,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                   if(resp.error_message === "success") {
                    bookadd.title = "";
                    bookadd.author = "";
                    bookadd.price = "";
                    bookadd.count = "";
                    bookadd.description = "";
                    refresh_books();
                       Modal.getInstance("#add_book_btn").hide();
                   } else {
                    bookadd.error_message = resp.error_message;
                   }
                }
            })
        };
        const update_book = (book) => {
            book.error_message = "";
            $.ajax({
                url: "http://localhost:3020/user/book/update/",
                type: "post",
                data: {
                    book_id: book.id,
                    title: book.title,
                    author: book.author,
                    price: book.price,
                    count: book.count,
                    description: book.description,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        refresh_books();
                        Modal.getInstance('#update_book_btn-' + book.id).hide();
                    } else {
                        book.error_message = resp.error_message;
                    }
                }
            })
        };
        refresh_books();

        return {
            books,
            bookadd,
            add_book,
            remove_book,
            update_book,
        }
    }
}
</script>

<style scoped>
.error-message {
    color: red;
}
</style>