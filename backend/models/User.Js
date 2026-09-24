const mongoose = require("mongoose");

const UserSchema = new mongoose.Schema({
    nome: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true,
        unique: true
    },
    senha: {
        type: String,
        required: true
    },
    dinheiro: {
        type: Number,
        default: 0
    },
    cargo: {
        type: String,
        default: "cliente"
    }
});

module.exports = mongoose.model("User", UserSchema);
