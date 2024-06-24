<template>
    <ContentFiled>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="register">
                    <div class="mb-3">
                        <label for="username" class="form-label">用户名</label>
                        <input v-model="username" type="text" class="form-control" id="username"
                            placeholder="请输入6-16位的用户名">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">密码</label>
                        <input v-model="password" type="password" class="form-control" id="password"
                            placeholder="请输入8-16位的密码">
                    </div>
                    <div class="mb-3">
                        <label for="confirmedpassword" class="form-label">确认密码</label>
                        <input v-model="confirmedpassword" type="password" class="form-control" id="confirmedpassword"
                            placeholder="请再次输入密码">
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">昵称</label>
                        <input v-model="name" type="text" class="form-control" id="name" placeholder="请输入2-10位的昵称">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">地址</label>
                        <textarea v-model="address" class="form-control" id="address" rows="3"></textarea>
                    </div>
                    <div class="error-message">{{ error_message }}</div>
                    <button type="submit" class="btn btn-success">注册</button>
                </form>
            </div>
        </div>
    </ContentFiled>
</template>

<script>
import ContentFiled from '@/components/ContentField'
import { ref } from 'vue'
import router from '@/router/index'
import $ from "jquery"

export default {
    components: {
        ContentFiled,
    },

    setup() {
        let username = ref("");
        let password = ref("");
        let confirmedpassword = ref("");
        let name = ref("");
        let address = ref("");
        let error_message = ref("");


        const register = () => {
            $.ajax({
                url: "http://localhost:3020/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: confirmedpassword.value,
                    name: name.value,
                    address: address.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                       router.push({name: "user_account_login"});
                    } else {
                        error_message.value = resp.error_message;
                    }
                }
            });
        };

        return {
            username,
            password,
            confirmedpassword,
            name,
            address,
            register,
            error_message
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}

.error-message {
    color: red;
}
</style>