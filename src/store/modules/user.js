export default {
  namespaced: true,
  state () {
    return {
      profile: {
        id: '',
        avatar: null,
        nickname: '',
        account: '',
        password: '',
        token: ''
      }
    }
  }
}
