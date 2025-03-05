<script>
import axiosInst from "@/axios";

//백엔드에서 데이터 가져오기
const getData = () => {
  //backend server : http://localhost:8080/emp
  //proxy server: http://localhost:5137/api/emp
  axiosInst.get("/emp").then((res) => {
    employees.value = res.data;
  });
};
</script>
<template>
    <h1>hi</h1>
</template>
<style></style>
