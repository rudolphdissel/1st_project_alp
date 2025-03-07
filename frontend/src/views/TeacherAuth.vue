<template>
  <div class="teacher-auth">
    <h1>교사 로그인</h1>
    
    <div class="auth-form">
      <input v-model="teacherName" placeholder="교사 이름을 입력하세요" class="name-input"/>
      <button @click="handleSubmit" :disabled="isSubmitting" class="submit-button">입장하기</button>
    </div>

    <RouterLink to="/" class="back-button">홈으로 돌아가기</RouterLink>
  </div>
</template>

<script>
import axiosInst from '@/axios';
import { useRouter } from 'vue-router';

export default {
  data() {
    return {
      teacherName: '',
      isSubmitting: false
    }
  },
  setup() {
    const router = useRouter();
    return { router }
  },
  created() {
    // 페이지 진입 시 기존 로그인 정보 초기화
    localStorage.removeItem('teacher_id');
    localStorage.removeItem('teacher_name');
  },
  methods: {
    async handleSubmit() {
      if (this.isSubmitting) return;
      
      const trimmedName = this.teacherName.trim();
      if (!trimmedName) {
        alert('교사 이름을 입력해주세요!');
        return;
      }

      this.isSubmitting = true;
      try {
        // 먼저 로그인 시도
        try {
          const loginResponse = await axiosInst.get(`/teachers/login/${trimmedName}`);
          if (loginResponse.data && loginResponse.data.teacher_id) {
            localStorage.setItem('teacher_id', loginResponse.data.teacher_id);
            localStorage.setItem('teacher_name', trimmedName);
            this.router.push('/teachermain');
          } else {
            throw new Error('Invalid login response');
          }
        } catch (loginError) {
          console.log('로그인 실패, 회원가입 시도');
          // 로그인 실패 시 회원가입 진행
          const registerResponse = await axiosInst.post('/teachers', {
            teacher_name: trimmedName
          });
          
          if (registerResponse.data && registerResponse.data.teacher_id) {
            localStorage.setItem('teacher_id', registerResponse.data.teacher_id);
            localStorage.setItem('teacher_name', trimmedName);
            this.router.push('/teachermain');
          } else {
            throw new Error('Invalid registration response');
          }
        }
      } catch (error) {
        console.error('처리 실패:', error);
        alert('처리 중 오류가 발생했습니다. 다시 시도해주세요.');
      } finally {
        this.isSubmitting = false;
      }
    }
  }
}
</script>

<style scoped>
.teacher-auth {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 80vh;
  padding: 20px;
}

h1 {
  color: #2c3e50;
  font-size: 2.5rem;
  margin-bottom: 2rem;
}

.auth-form {
  display: flex;
  flex-direction: column;
  gap: 15px;
  width: 100%;
  max-width: 300px;
}

.name-input {
  padding: 12px;
  font-size: 16px;
  border: 2px solid #4CAF50;
  border-radius: 8px;
  width: 100%;
  text-align: center;
}

.name-input:focus {
  outline: none;
  border-color: #45a049;
  box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
}

.submit-button {
  padding: 12px;
  font-size: 16px;
  color: white;
  background-color: #4CAF50;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.submit-button:hover {
  background-color: #45a049;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.back-button {
  margin-top: 20px;
  color: #666;
  text-decoration: none;
  font-size: 14px;
  transition: color 0.3s;
}

.back-button:hover {
  color: #4CAF50;
}
</style> 