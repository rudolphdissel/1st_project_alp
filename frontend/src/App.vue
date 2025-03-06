<script>
import StudentManage from "./components/StudentManage.vue";

export default {
  name: "App",
  components: {
    StudentManage,
  },
};
</script>

<template>
  <div id="app">
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
