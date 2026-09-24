const mongoose = require("mongoose");

const OrderSchema = new mongoose.Schema({
    usuarioId: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "User"
    },
    produtoId: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Product"
    },
    quantidade: Number,
    valorTotal: Number,
    status: {
        type: String,
        default: "Aguardando Pagamento"
    }
});

module.exports = mongoose.model("Order", OrderSchema);
