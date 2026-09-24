const express = require("express");

const router = express.Router();

router.get("/", (req, res) => {
    res.json({
        mensagem: "Lista de usuários"
    });
});

module.exports = router;
