<template>
  <div class="student-manage">
    <h2>학생 관리</h2>
    
    <!-- 학생 등록 폼 -->
    <div class="student-form">
      <input v-model="newStudent.name" placeholder="이름" />
      <input v-model="newStudent.grade" placeholder="학년" />
      <button @click="addStudent">등록</button>
    </div>

    <!-- 학생 목록 -->
    <div class="student-list">
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>이름</th>
            <th>학년</th>
            <th>작업</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="student in students" :key="student.id">
            <td>{{ student.id }}</td>
            <td>{{ student.name }}</td>
            <td>{{ student.grade }}</td>
            <td>
              <button @click="deleteStudent(student.id)">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'StudentManage',
  data() {
    return {
      students: [],
      newStudent: {
        name: '',
        grade: ''
      }
    };
  },
  methods: {
    async fetchStudents() {
      try {
        const response = await axios.get('http://localhost:8080/api/students');
        this.students = response.data;
      } catch (error) {
        console.error('학생 목록 조회 실패:', error);
      }
    },
    async addStudent() {
      try {
        await axios.post('http://localhost:8080/api/students', this.newStudent);
        this.newStudent = { name: '', grade: '' };
        await this.fetchStudents();
      } catch (error) {
        console.error('학생 등록 실패:', error);
      }
    },
    async deleteStudent(id) {
      try {
        await axios.delete(`http://localhost:8080/api/students/${id}`);
        await this.fetchStudents();
      } catch (error) {
        console.error('학생 삭제 실패:', error);
      }
    }
  },
  mounted() {
    this.fetchStudents();
  }
};
</script>

<style scoped>
.student-manage {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.student-form {
  margin-bottom: 20px;
}

.student-form input {
  margin-right: 10px;
  padding: 5px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 10px;
  border: 1px solid #ddd;
  text-align: left;
}

th {
  background-color: #f5f5f5;
}

button {
  padding: 5px 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}

button.delete {
  background-color: #f44336;
}

button.delete:hover {
  background-color: #da190b;
}
</style> 