<template>
    <ContentFiled>
        <div class="card" style="margin-top: 20px;">
            <div class="card-header">
                <span style="font-size: 140%;">交易记录</span>
            </div>
            <div class="card-body">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>买家</th>
                            <th>卖家</th>
                            <th>书名</th>
                            <th>价格</th>
                            <th>交易时间</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="record in records" :key="record.id">
                            <td>{{ record.buyername }}</td>
                            <td>{{ record.sellername }}</td>
                            <td>{{ record.bookname }}</td>
                            <td>{{ record.price }}</td>
                            <td>{{ record.createtime }}</td>
                        </tr>
                    </tbody>
                </table>
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
            </div>
        </div>
    </ContentFiled>
</template>

<script>
import ContentFiled from '@/components/ContentField'
import { useStore } from 'vuex'
import $ from 'jquery'
import { ref } from 'vue'

export default {
    components: {
        ContentFiled,
    },
    setup() {
        const store = useStore();
        let current_page = 1;
        let records = ref([]);
        let total_records = 0;
        let pages = ref([]);


        const update_pages = () => {
            let max_pages = parseInt(Math.ceil(total_records / 12));
            let new_pages = [];
            for (let i = current_page - 2; i <= current_page + 2; i++) {
                if (i >= 1 && i <= max_pages) {
                    new_pages.push({
                        number: i,
                        is_active: i === current_page ? "active" : "",
                    });
                }
            }
            pages.value = new_pages;
        }

        const click_page = page => {
            if (page === -2) page = current_page - 1;
            else if (page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_records / 12));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://localhost:3020/record/getrecord/",
                type: "get",
                data: {
                    page,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    records.value = resp.records;
                    total_records = resp.records_count;
                    update_pages();
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }

        pull_page(current_page);

        return {
            records,
            pages,
            click_page,
        }

    }
}
</script>

<style scoped></style>