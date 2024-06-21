<template>
    <nav class="navbar navbar-expand-lg bg-dark-subtle" data-bs-theme="dark">
        <div class=" container">
            <router-link class="navbar-brand" :to="{name: 'home'}">花椒书店</router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link :class="route_name == 'buybook_index' ? 'nav-link active' : 'nav-link'" aria-current="page"
                            :to="{ name: 'buybook_index'}">首页</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :class="route_name == 'sellbook_index' ? 'nav-link active' : 'nav-link'" :to="{ name: 'sellbook_index'}">我要卖书</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :class="route_name == 'mybuy_index' ? 'nav-link active' : 'nav-link'" :to="{ name: 'mybuy_index' }">交易记录</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            ldx
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">我的余额：0</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <router-link class="dropdown-item" :to="{ name: 'user_index'}">个人信息</router-link>
                            <li>
                                <hr class=" dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { useRoute } from 'vue-router';
import { computed } from 'vue';

export default {
    setup() {
        const route = useRoute();
        let route_name = computed(() => route.name)
        return {
            route_name,
        }
    }
}
</script>

<style scoped>

</style>