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
                        <div class="card-body">
                            <dl class="row">
                                <dt class="col-sm-3" style="font-size: xx-large;">用户名</dt>
                                <dd class="col-sm-9" style="font-size: xx-large;">{{ $store.state.user.username }}</dd>
                                <p></p>
                                <dt class="col-sm-3" style="font-size: xx-large;">昵称</dt>
                                <dd class="col-sm-9" style="font-size: xx-large;">{{ $store.state.user.name }}</dd>
                                <p></p>
                                <dt class="col-sm-3" style="font-size: xx-large;">余额</dt>
                                <dd class="col-sm-9" style="font-size: xx-large;">{{ $store.state.user.money }}</dd>
                                <p></p>
                                <dt class="col-sm-3" style="font-size: xx-large;">地址</dt>
                                <dd class="col-sm-9" style="font-size: xx-large;">{{ $store.state.user.address }}</dd>

                            </dl>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentFiled>
</template>

<script>
import ContentFiled from '@/components/ContentField'

export default {
    components: {
        ContentFiled,
    }
}
</script>

<style scoped>
</style>