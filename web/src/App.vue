<template>
  <NavBar />
  <router-view></router-view>
</template>

<script>
import NavBar from '@/components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap";

export default {
  components: {
    NavBar
  },
}


</script>

<style>
body {
  background-color: rgb(182,211,151);
}
</style>
