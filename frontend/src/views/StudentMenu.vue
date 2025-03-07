<template>
  <div class="home">
    <h1>이곳은 학생 페이지입니다!</h1>
    <div class="subjects">
      <button
        v-for="subject in subjects"
        :key="subject.id"
        @click="fetchUnits(subject.id)"
        class="nav-link"
      >
        {{ subject.name }}
      </button>
    </div>
    <div class="units" v-if="units.length > 0">
      <h2>단원 목록</h2>
      <ul>
        <li v-for="unit in units" :key="unit.id">{{ unit.name }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axiosInst from "@/axios";

export default {
  setup() {
    const subjects = ref([]);
    const units = ref([]);

    const fetchSubjects = async () => {
      try {
        const res = await axiosInst.get("/subjects");
        subjects.value = res.data;
      } catch (error) {
        console.error("Error fetching subjects:", error);
      }
    };

    const fetchUnits = async (subjectId) => {
      try {
        const res = await axiosInst.get(`/subjects/${subjectId}/units`);
        units.value = res.data;
      } catch (error) {
        console.error("Error fetching units:", error);
      }
    };

    onMounted(() => {
      fetchSubjects();
    });

    return {
      subjects,
      units,
      fetchUnits,
    };
  },
};
</script>

<style scoped>
.home {
  text-align: center;
  padding: 20px;
}

.nav-link {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #4caf50;
  color: white;
  text-decoration: none;
  border-radius: 3px;
}

.nav-link:hover {
  background-color: #45a049;
}
</style>
