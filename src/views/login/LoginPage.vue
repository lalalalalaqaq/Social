<template>
  <div class="login-page-container">
    <el-form :model="userInfo" ref="formRef" :rules="formRules" :inline="false" size="default">
      <el-form-item prop="account" class="input-title-container">
        <span>{{ $t('login.account') }}</span>
        <RouterLink to="/" class="goto-register">{{ $t('login.toSignUp') }}</RouterLink>
        <el-input v-model.trim="userInfo.account"></el-input>
      </el-form-item>

      <el-form-item prop="password" class="input-title-container">
        <span>{{ $t('login.password') }}</span>
        <RouterLink to="/" class="forgot-password-text">{{ $t('login.forgetPass') }}</RouterLink>
        <el-input type="password" v-model.trim="userInfo.password" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button :loading="loading" class="login" @click="signIn(formRef)">{{ $t('login.login') }}</el-button>
        <el-button @click="resetForm(formRef)" class="reset">{{ $t('login.reset') }}</el-button>
      </el-form-item>
    </el-form>
    <div class="bg-physics">
      <PhysicsPage />
    </div>
  </div>
</template>

<script>
import PhysicsPage from '@/components/Background/physicsPage.vue'
import { reactive, ref } from 'vue'
import { useI18n } from 'vue-i18n'
import { userLogin } from '@/api/login'
import { useRouter } from 'vue-router'
export default {
  name: 'LoginPage',
  components: {
    PhysicsPage
  },
  setup () {
    const formRef = ref()
    const loading = ref(false)
    const userInfo = reactive({ account: '', password: '' })
    const { t } = useI18n()
    const router = useRouter()
    const valAccount = (rule, value, callback) => {
      if (!value) {
        return callback(new Error(t('login.accountIsEmpty')))
      }
      const reg = /[`~!@#$%^&*()+=|{}':;',\\[\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]/g
      if (value.length > 16 || value.length < 4) {
        callback(new Error(t('login.enterAccountMessage')))
      } else {
        if (reg.test(value)) {
          callback(new Error(t('login.enterAccountMessage')))
        } else {
          callback()
        }
      }
    }

    const valPassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error(t('login.passIsEmpty')))
      }
      const reg = /[`~!@#$%^&*()+=|{}':;',\\[\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]/g
      if (value.length > 16 || value.length < 8) {
        callback(new Error(t('login.enterPasswordMessage')))
      } else {
        if (reg.test(value)) {
          callback(new Error(t('login.enterPasswordMessage')))
        } else {
          callback()
        }
      }
    }

    const formRules = reactive({
      account: [
        { validator: valAccount, required: true, trigger: 'blur' }
      ],
      password: [
        { validator: valPassword, required: true, trigger: 'blur' }
      ]
    })

    const signIn = (formEl) => {
      if (!formEl) return
      formEl.validate((valid) => {
        if (valid) {
          loading.value = true
          console.log(valid)
          userLogin({ userAccount: userInfo.account, userPassword: userInfo.password }).then((res) => {
            console.log(res)
            if (res.status === 200) {
              //
              setTimeout(() => {
                loading.value = false
                router.replace({ path: '/home' })
              }, 2000)
            }
          })
        } else {
          console.log('Login submit error!')
          return false
        }
      })
    }

    const resetForm = (formEl) => {
      if (!formEl) return
      formEl.resetFields()
    }

    return {
      formRef,
      loading,
      formRules,
      userInfo,
      signIn,
      resetForm
    }
  }
}
</script>

<style lang='scss' scoped>
.login-page-container {
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;

  .el-form {
    user-select: none;
    position: absolute;
    bottom: 0;
    top: 0;
    left: 0;
    right: 0;
    margin: auto;
    padding: 40px;
    width: 400px;
    height: 300px;
    border: 1px solid #999;
    border-radius: 12px;

    .el-form-item :deep(.el-form-item__content) {
      margin: 10px 0;
    }

    .input-title-container {
      position: relative;
      font-weight: bold;

      span {
        font-size: 16px;
      }

      .forgot-password-text,
      .goto-register {
        position: absolute;
        right: 0;
        top: 0;
        text-decoration: none;
      }
    }

    .el-form-item :deep(.el-input__wrapper) {
      padding: 0;
      box-shadow: none;
      border-radius: 8px;

      .el-input__suffix>.el-input__suffix-inner>.el-icon {
        margin: 0 8px;
      }
    }

    .el-input :deep(.el-input__inner) {
      width: 100%;
      height: 40px;
      line-height: 28px;
      padding: 1px 20px;
      border: 2px solid transparent;
      border-radius: 8px;
      outline: none;
      background-color: #f3f3f4;
      color: #0d0c22;
      transition: .3s ease;

      &::placeholder {
        color: #9e9ea7;
      }

      &:focus,
      &:hover {
        outline: none;
        border-color: rgba(234, 76, 137, 0.4);
        background-color: #fff;
        box-shadow: 0 0 0 4px rgb(234 76 137 / 10%);
      }
    }

    .el-form-item__content {
      .login {
        margin: 10px auto 0;
        padding: 1.3em 3em;
        letter-spacing: 2.5px;
        font-weight: 800;
        color: #000;
        background-color: #fff;
        border: none;
        border-radius: 45px;
        box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
        transition: all 0.3s ease 0s;
        cursor: pointer;
        outline: none;
        font-size: 16px;

        &:hover {
          background-color: #23c483;
          box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
          color: #fff;
          transform: translateY(-7px);
        }

        &:active {
          transform: translateY(-1px);
        }
      }

      .reset {
        margin: 10px auto;
        color: #090909;
        padding: 0.7em 1.7em;
        font-size: 18px;
        letter-spacing: 2.5px;
        border-radius: 1em;
        background: #e8e8e8;
        border: 1px solid #e8e8e8;
        transition: all .3s;
        font-weight: 800;
        border: 1px solid transparent;
        box-shadow: 6px 6px 12px #c5c5c5,
          -6px -6px 12px #ffffff;

        &:hover {
          border: 1px solid white;
        }

        &:active {
          box-shadow: 4px 4px 12px #c5c5c5,
            -4px -4px 12px #ffffff;
        }
      }
    }
  }

  .bg-physics {
    width: 100%;
    height: 100%;
  }
}
</style>
