<template>
  <div class="login-page-container">
    <el-form :model="userInfo" ref="formRef" :rules="formRules" :inline="false" size="default">
      <el-form-item prop="account" class="input-title-container">
        <span>{{ $t('login.account') }}</span>
        <RouterLink to="/" class="goto-register">{{ $t('login.toSignUp') }}</RouterLink>
        <el-input v-model.trim="userInfo.account" clearable></el-input>
      </el-form-item>

      <el-form-item prop="password" class="input-title-container">
        <span>{{ $t('login.password') }}</span>
        <RouterLink to="/" class="forgot-password-text">{{ $t('login.forgetPass') }}</RouterLink>
        <el-input type="password" v-model.trim="userInfo.password" clearable></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="Login(formRef)">{{ $t('login.login') }}</el-button>
        <el-button @click="resetForm(formRef)">{{ $t('login.reset') }}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { reactive, ref } from 'vue'
import { useI18n } from 'vue-i18n'
export default {
  name: 'LoginPage',
  setup () {
    const formRef = ref()
    const userInfo = reactive({ account: '', password: '' })
    const { t } = useI18n()

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

    const Login = (formEl) => {
      if (!formEl) return
      formEl.validate((valid) => {
        if (valid) {
          console.log(valid)
        } else {
          console.log('error')
        }
      })
    }

    const resetForm = (formEl) => {
      if (!formEl) return
      formEl.resetFields()
    }

    return {
      formRef,
      formRules,
      userInfo,
      Login,
      resetForm
    }
  }
}
</script>

<style lang='scss' scoped>
.login-page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;

  .el-form {
    padding: 40px;
    width: 400px;
    height: 300px;
    border: 1px solid #999;

    .input-title-container {
      position: relative;

      .forgot-password-text,
      .goto-register {
        position: absolute;
        right: 0;
        top: 0;
        text-decoration: none;
      }
    }

    .el-form-item__content {
      .el-button {
        margin: 10px auto;
        color: #090909;
        padding: 0.7em 1.7em;
        font-size: 18px;
        border-radius: 0.5em;
        background: #e8e8e8;
        border: 1px solid #e8e8e8;
        transition: all .3s;
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
}
</style>
