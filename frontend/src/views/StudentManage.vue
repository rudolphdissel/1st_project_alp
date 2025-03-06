<script setup>
import { onBeforeMount, ref } from 'vue';
import { useRouter } from 'vue-router';
import axiosInst from "@/axios";

// 목록 데이터 사전 준비
onBeforeMount(()=>{
  getData();
});

//백엔드에서 데이터 가져오기
const getData = () => {
  //backend server : http://localhost:8080/emp
  //proxy server: http://localhost:5137/api/emp
  axiosInst.get("/students").then((res) => {
    student.value = res.data;
  });
};
</script>
<template>
  <div>
    <h1>학생 목록</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>이름</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in students" :key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.name }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

th {
  background-color: #f2f2f2;
}
</style>
