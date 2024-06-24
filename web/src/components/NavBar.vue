<template>
    <nav class="navbar navbar-expand-lg bg-dark-subtle" data-bs-theme="dark">
        <div class=" container">
            <img src="@/assets/ecjtu.png" alt="" width="40" height="40" class="d-inline-block align-text-top">
            <router-link class="navbar-brand" :to="{name: 'home'}">
                花椒书店
            </router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link :class="route_name == 'buybook_index' ? 'nav-link active' : 'nav-link'"
                            aria-current="page" :to="{ name: 'buybook_index'}">首页</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :class="route_name == 'sellbook_index' ? 'nav-link active' : 'nav-link'"
                            :to="{ name: 'sellbook_index'}">我要卖书</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :class="route_name == 'mybuy_index' ? 'nav-link active' : 'nav-link'"
                            :to="{ name: 'mybuy_index' }">交易记录</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav" v-if="$store.state.user.is_login">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            {{ $store.state.user.name }}
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">我的余额：{{ $store.state.user.money }}</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <router-link class="dropdown-item" :to="{ name: 'user_index'}">个人信息</router-link>
                            <li>
                                <hr class=" dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" @click="logout" href="#">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav" v-else-if="!$store.state.user.pulling_info">
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'user_account_login' }" role="button">
                            登录
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'user_account_register' }" role="button">
                            注册
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { useRoute } from 'vue-router';
import { computed } from 'vue';
import { useStore } from 'vuex';


export default {
    setup() {
        const store = useStore();
        const route = useRoute();
        let route_name = computed(() => route.name)

        const logout = () => {
            store.dispatch("logout");
        }

        return {
            route_name,
            logout,
        }
    }
}
</script>

<style scoped>

</style>