<template>
  <div class="register-page-container">
    <el-form :model="newAccount" ref="formRef" :rules="formRules" size="default">
      <div class="goto-login-page">
        <span>{{ $t('register.hasAccount') + ' ' }}</span>
        <Router-link to="/login">{{ $t('login.login') }}</Router-link>
      </div>
      <el-form-item class="input-title-container" prop="account">
        <span>{{ $t('register.account') }}</span>
        <el-input v-model="newAccount.account"></el-input>
      </el-form-item>
      <!-- <el-form-item>
        <span>Email</span>
        <el-input v-model="newAccount.email"></el-input>
      </el-form-item> -->
      <el-form-item class="input-title-container" prop="password">
        <span>{{ $t('register.password') }}</span>
        <el-input show-password :placeholder="$t('register.passwordPlaceholder')" v-model="newAccount.password">
        </el-input>
        <transition name="fade">
          <div class="password-security" :class="security" v-if="pswLength >= 8 && pswLength <= 16">
            <div class="linear-color">
              <div class="color-bar red"></div>
              <div class="color-bar yellow"></div>
            </div>
            <div class="color-bar green"></div>
          </div>
        </transition>
      </el-form-item>
      <el-form-item class="input-title-container" prop="checkPassword">
        <span>{{ $t('register.checkPassword') }}</span>
        <el-input show-password v-model="newAccount.checkPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button :loading="loading" class="register" type="primary" @click="signUp(formRef)">
          {{ $t('register.register') }}
        </el-button>
      </el-form-item>
      <el-form-item class="protocol-container" prop="agree">
        <el-checkbox size="large" id="user_agree_to_terms" v-model="newAccount.agree"></el-checkbox>
        <label for="user_agree_to_terms" class="protocolText" style="letter-spacing: 1px;">
          Creating an account means you're okay with our
          <a href="" target="_blank">Terms of Service</a>,
          <a href="" target="_blank">Privacy Policy</a>, and our default
          <a href="" target="_blank">Notification Settings</a>
        </label>
      </el-form-item>
    </el-form>
    <div class="bg-physics">
      <PhysicsPage />
    </div>
  </div>
</template>

<script>
import PhysicsPage from '@/components/Background/physicsPage.vue'
import { computed, reactive, ref, watch } from 'vue'
import { useI18n } from 'vue-i18n'
import { ElMessageBox } from 'element-plus'
import { userRegister } from '@/api/register'
import { useRouter } from 'vue-router'
export default {
  name: 'registerPage',
  components: {
    PhysicsPage
  },
  setup () {
    const formRef = ref()
    const newAccount = reactive({
      account: '',
      // email: '',
      password: '',
      checkPassword: '',
      agree: false
    })
    const loading = ref(false)
    const security = ref('none')
    const router = useRouter()
    const pswLength = computed(() => {
      return newAccount.password.length
    })
    const { t } = useI18n()

    const valAccount = (rule, value, callback) => {
      if (!value) {
        return callback(new Error(t('register.accountIsEmpty')))
      }
      const reg = /[`~!@#$%^&*()+=|{}':;',\\[\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]/g
      if (value.length > 16 || value.length < 4) {
        callback(new Error(t('register.enterAccountMessage')))
      } else {
        if (reg.test(value)) {
          callback(new Error(t('register.enterAccountMessage')))
        } else {
          callback()
        }
      }
    }

    const valPassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error(t('register.accountIsEmpty')))
      }
      if (value.length > 16 || value.length < 8) {
        callback(new Error(t('register.enterAccountMessage')))
      } else {
        const reg = /^(.)\1*$/g
        if (reg.test(value)) {
          callback(new Error(t('register.passTooLow')))
        } else {
          callback()
        }
      }
    }

    const valCheck = (rule, value, callback) => {
      if (!value) {
        callback(new Error(t('register.checkWrong')))
      } else {
        if (value !== newAccount.password) {
          callback(new Error(t('register.checkWrong')))
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
      ],
      checkPassword: [
        { validator: valCheck, required: true, trigger: 'blur' }
      ]
    })

    watch(() => newAccount.password, (newVal) => {
      const securityNum = Number(/\d/.test(newVal) + /[a-zA-Z]/.test(newVal) + /[^a-zA-Z0-9]/.test(newVal))
      security.value = securityNum === 3 ? 'strong' : securityNum === 2 ? 'medium' : securityNum === 1 ? 'low' : 'none'
    })

    const signUp = (formEl) => {
      if (!formEl) return
      formEl.validate((valid) => {
        if (valid) {
          if (!newAccount.agree) {
            ElMessageBox({
              type: 'info',
              message: t('register.plzAgree'),
              showCancelButton: true,
              confirmButtonText: t('register.confirmAgree'),
              cancelButtonText: t('register.cancelAgree'),
              beforeClose: (action, instance, done) => {
                if (action === 'confirm') {
                  newAccount.agree = true
                  done()
                } else {
                  done()
                }
              }
            })
          } else {
            console.log(newAccount)
            loading.value = true
            // 调用接口跳转主页 home
            userRegister({ userAccount: newAccount.account, userPassword: newAccount.password }).then(res => {
              console.log(res)
              if (res.status === 200) {
                //
                setTimeout(() => {
                  loading.value = false
                  router.replace('/home')
                }, 2000)
              }
            })
          }
        } else {
          console.log('Register submit error!')
          return false
        }
      })
    }

    return {
      formRef,
      loading,
      security,
      pswLength,
      newAccount,
      formRules,
      signUp
    }
  }
}
</script>

<style lang='scss' scoped>
.register-page-container {
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;

  .el-form {
    user-select: none;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    margin: auto;
    padding: 40px;
    width: 400px;
    height: 500px;
    border-radius: 12px;
    border: 1px solid #999;

    .input-title-container {
      span {
        font-size: 16px;
      }
    }

    .goto-login-page {
      position: absolute;
      top: 5px;
      right: 10px;
      font-size: 16px;

      a {
        font-weight: 600;
      }
    }

    .protocol-container :deep(.el-form-item__content) {
      align-items: start;
      flex-wrap: nowrap;

      label {
        margin: 8px 0 0 8px;
        line-height: 20px;
        display: inline-block;
        user-select: none;
        cursor: pointer;

        a {
          color: blueviolet;
          font-weight: 600;
        }
      }
    }

    .el-form-item :deep(.el-form-item__content) {
      margin: 10px 0;
    }

    .input-title-container {
      position: relative;
      font-weight: bold;

      .password-security {
        display: flex;
        position: absolute;
        right: 0;
        bottom: -34px;
        width: 120px;
        height: 16px;
        opacity: 0;
        transition: all .5s;
        border-radius: 8px;
        border: 1px dashed #333;
        background: transparent;

        .linear-color {
          display: flex;
        }

        .color-bar {
          width: 40px;
          height: 16px;
          transition: all .5s;
          background: transparent;

          &.red {
            border-radius: 8px 0 0 8px;
          }

          &.yellow {
            border-width: 0 1px 0 1px;
            border-right: 1px solid #333;
            border-left: 1px solid #333;
          }

          &.green {
            border-radius: 0 8px 8px 0;
          }
        }

        &.none {
          opacity: 1;
          background: transparent;
        }

        &.low {
          opacity: 1;

          .red {
            background: #FF416C;
          }

          .green,
          .yellow {
            background: transparent;
          }
        }

        &.medium {
          opacity: 1;

          .linear-color {
            border-radius: 8px 0 0 8px;
            background: linear-gradient(to right, #FF416C, #ff8c00);
          }

          .green {
            background: transparent;
          }
        }

        &.strong {
          opacity: 1;
          background: linear-gradient(to right, #FF416C, #ff8c00, #45B649);
        }
      }
    }

    .el-form-item :deep(.el-input__wrapper) {
      padding: 0 0;
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
      .register {
        margin: 10px auto 0;
        padding: 1.3em 3em;
        letter-spacing: 2.5px;
        font-weight: 800;
        font-size: 16px;
        color: #000;
        background-color: #fff;
        border: none;
        border-radius: 45px;
        box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
        transition: all 0.3s ease 0s;
        cursor: pointer;
        outline: none;

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
    }
  }

  .bg-physics {
    width: 100%;
    height: 100%;
  }
}
</style>
