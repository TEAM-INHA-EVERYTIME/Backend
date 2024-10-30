const express = require('express');
const authRoutes = require('./src/route/authRoutes');
const swaggerDocs = require('./swagger/swagger');
require('dotenv').config();

const app = express();
app.use(express.json());

app.use('/auth', authRoutes);
swaggerDocs(app);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
