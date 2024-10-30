const express = require('express');
const { register, login } = require('../controller/authController');
const router = express.Router();

// 회원가입 라우트
router.post('/register', register);

// 로그인 라우트
router.post('/login', login);

module.exports = router;
