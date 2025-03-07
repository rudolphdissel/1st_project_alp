<template>
  <div class="student-manage">
    <h1>학생 관리</h1>
    
    <!-- 학생 등록 폼 -->
    <div class="add-student-form">
      <input 
        type="text" 
        v-model="newStudentName" 
        placeholder="학생 이름을 입력하세요"
        class="student-input"
      >
      <button @click="addStudent" class="add-button">등록</button>
    </div>

    <!-- 학생 목록 테이블 -->
    <div class="student-table">
      <table>
        <thead>
          <tr>
            <th>순번</th>
            <th>교사 이름</th>
            <th>학생 이름</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(student, index) in students" :key="student.studentId">
            <td>{{ index + 1 }}</td>
            <td>{{ student.teacher.teacherName }}</td>
            <td>{{ student.studentName }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axiosInst from '../axios'

export default {
  name: 'StudentManage',
  data() {
    return {
      students: [],
      newStudentName: '',
      teacherId: null
    }
  },
  created() {
    // localStorage에서 teacherId 가져오기
    this.teacherId = localStorage.getItem('teacherId')
    if (!this.teacherId) {
      this.$router.push('/teacherlogin')
      return
    }
    this.fetchStudents()
  },
  methods: {
    async fetchStudents() {
      try {
        const response = await axiosInst.get('/api/students')
        this.students = response.data
      } catch (error) {
        console.error('학생 목록을 가져오는데 실패했습니다:', error)
        alert('학생 목록을 가져오는데 실패했습니다.')
      }
    },
    async addStudent() {
      if (!this.newStudentName.trim()) {
        alert('학생 이름을 입력해주세요.')
        return
      }

      try {
        const response = await axiosInst.post('/api/students', {
          studentName: this.newStudentName.trim(),
          teacher: {
            teacherId: parseInt(this.teacherId)
          }
        })
        
        // 입력 필드 초기화
        this.newStudentName = ''
        
        // 학생 목록 새로고침
        await this.fetchStudents()
      } catch (error) {
        console.error('학생 등록에 실패했습니다:', error)
        alert('학생 등록에 실패했습니다.')
      }
    }
  }
}
</script>

<style scoped>
.student-manage {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
}

h1 {
  color: #333;
  margin-bottom: 30px;
  text-align: center;
}

.add-student-form {
  display: flex;
  gap: 10px;
  margin-bottom: 30px;
}

.student-input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
}

.add-button {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.add-button:hover {
  background-color: #45a049;
}

.student-table {
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f5f5f5;
  font-weight: bold;
}

tr:hover {
  background-color: #f9f9f9;
}
</style>
