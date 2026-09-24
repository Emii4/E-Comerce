const mongoose = require("mongoose");

const ProductSchema = new mongoose.Schema({
    nome: String,
    preco: Number,
    estoque: Number,
    imagem: String,
    descricao: String
});

module.exports = mongoose.model("Product", ProductSchema);
