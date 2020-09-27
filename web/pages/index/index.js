//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    show: true,
    actions: [
      { name: '获取用户信息', color: '#07c160', openType: 'getUserInfo' },
    ],
  },

  onClose() {
    this.setData({ show: false });
  },

  onGetUserInfo(e) {
    console.log(e.detail);
  }
})
