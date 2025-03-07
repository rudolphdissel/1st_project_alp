<template>
  <div class="student-manage">
    <h2>학생 관리</h2>
    
    <!-- 학생 등록 폼 -->
    <div class="student-form">
      <input v-model.trim="newStudent.student_name" placeholder="이름" />
      <input v-model.trim="newStudent.gender" placeholder="성별" />
      <button @click="addStudent" :disabled="isSubmitting">등록</button>
    </div>

    <!-- 학생 목록 -->
    <div class="student-list">
      <table>
        <thead>
          <tr>
            <th>이름</th>
            <th>성별</th>
            <th>작업</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="student in students" :key="student.student_id">
            <td>{{ student.student_name }}</td>
            <td>{{ student.gender }}</td>
            <td>
              <button @click="deleteStudent(student.student_id)" 
                      class="delete" 
                      :disabled="isSubmitting">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axiosInstance from '@/axios';

export default {
  name: 'StudentManage',
  data() {
    return {
      students: [],
      isSubmitting: false,
      newStudent: {
        student_name: '',
        gender: '',
        teacher: {
          teacher_id: localStorage.getItem('teacher_id')
        }
      }
    };
  },
  methods: {
    async fetchStudents() {
      try {
        const teacherId = localStorage.getItem('teacher_id');
        if (!teacherId) {
          console.error('교사 ID가 없습니다.');
          return;
        }
        const response = await axiosInstance.get(`/students?teacher_id=${teacherId}`);
        this.students = Array.isArray(response.data) ? response.data : [];
      } catch (error) {
        console.error('학생 목록 조회 실패:', error);
        this.students = [];
      }
    },
    async addStudent() {
      if (this.isSubmitting) return;
      
      if (!this.newStudent.student_name || !this.newStudent.gender) {
        alert('이름과 성별을 모두 입력해주세요.');
        return;
      }

      this.isSubmitting = true;
      try {
        const response = await axiosInstance.post('/students', this.newStudent);
        await this.fetchStudents();
        // 입력 폼 초기화
        this.newStudent = {
          student_name: '',
          gender: '',
          teacher: {
            teacher_id: localStorage.getItem('teacher_id')
          }
        };
      } catch (error) {
        console.error('학생 등록 실패:', error);
        alert('학생 등록에 실패했습니다.');
      } finally {
        this.isSubmitting = false;
      }
    },
    async deleteStudent(studentId) {
      if (this.isSubmitting) return;
      
      this.isSubmitting = true;
      try {
        await axiosInstance.delete(`/students/${studentId}`);
        await this.fetchStudents();
      } catch (error) {
        console.error('학생 삭제 실패:', error);
        alert('학생 삭제에 실패했습니다.');
      } finally {
        this.isSubmitting = false;
      }
    }
  },
  created() {
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
  display: flex;
  gap: 10px;
}

.student-form input {
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  flex: 1;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

th, td {
  padding: 12px;
  border: 1px solid #ddd;
  text-align: left;
}

th {
  background-color: #4CAF50;
  color: white;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

button {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
}

button:not(:disabled):hover {
  background-color: #45a049;
  transform: translateY(-2px);
  box-shadow: 0 2px 4px rgba(0,0,0,0.2);
}

button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

button.delete {
  background-color: #f44336;
}

button.delete:not(:disabled):hover {
  background-color: #da190b;
}
</style>
