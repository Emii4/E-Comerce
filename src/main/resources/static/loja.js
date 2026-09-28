const listaProdutos = document.getElementById('listaProdutos');
const carrinhoEl = document.getElementById('carrinho');
const formulario = document.getElementById('formCadastro');
const mensagemEl = document.getElementById('mensagem');

let totalCarrinho = 0;

function formatarMoeda(valor) {
  return Number(valor).toLocaleString('pt-BR', {
    style: 'currency',
    currency: 'BRL'
  });
}

function limparMensagem() {
  mensagemEl.textContent = '';
}

function mostrarMensagem(texto, sucesso = true) {
  mensagemEl.textContent = texto;
  mensagemEl.style.color = sucesso ? '#1e8e5a' : '#b5121b';
}

function renderizarProdutos(produtos) {
  listaProdutos.innerHTML = '';

  produtos.forEach((produto) => {
    const card = document.createElement('article');
    card.className = 'card-produto';

    const imagem = document.createElement('img');
    imagem.src = produto.imagem || 'https://via.placeholder.com/600x400?text=Produto';
    imagem.alt = produto.nome;

    const conteudo = document.createElement('div');
    conteudo.className = 'conteudo';

    const titulo = document.createElement('h3');
    titulo.textContent = produto.nome;

    const descricao = document.createElement('p');
    descricao.textContent = produto.descricao;

    const linha = document.createElement('div');
    linha.className = 'linha';

    const preco = document.createElement('span');
    preco.className = 'preco';
    preco.textContent = formatarMoeda(produto.preco);

    const estoque = document.createElement('span');
    estoque.className = 'estoque';
    estoque.textContent = `Estoque: ${produto.estoque}`;

    const botao = document.createElement('button');
    botao.type = 'button';
    botao.textContent = 'Adicionar';
    botao.addEventListener('click', () => {
      totalCarrinho += Number(produto.preco);
      carrinhoEl.textContent = `Carrinho: ${formatarMoeda(totalCarrinho)}`;
    });

    linha.appendChild(preco);
    linha.appendChild(estoque);
    conteudo.append(titulo, descricao, linha, botao);
    card.append(imagem, conteudo);
    listaProdutos.appendChild(card);
  });
}

async function carregarProdutos() {
  try {
    const resposta = await fetch('/api/produtos');
    if (!resposta.ok) {
      throw new Error('Erro ao buscar produtos.');
    }

    const produtos = await resposta.json();
    renderizarProdutos(produtos);
  } catch (erro) {
    listaProdutos.innerHTML = '<p>Não foi possível carregar os produtos.</p>';
    mostrarMensagem(erro.message, false);
  }
}

formulario.addEventListener('submit', async (evento) => {
  evento.preventDefault();
  limparMensagem();

  const dados = {
    nome: document.getElementById('nome').value,
    descricao: document.getElementById('descricao').value,
    preco: document.getElementById('preco').value,
    estoque: document.getElementById('estoque').value,
    categoria: document.getElementById('categoria').value || 'Smartphones',
    imagem: document.getElementById('imagem').value || 'https://via.placeholder.com/600x400?text=Produto'
  };

  try {
    const resposta = await fetch('/api/produtos', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(dados)
    });

    const texto = await resposta.text();

    if (!resposta.ok) {
      throw new Error(texto || 'Erro ao cadastrar produto.');
    }

    formulario.reset();
    document.getElementById('categoria').value = 'Smartphones';
    mostrarMensagem('Produto cadastrado com sucesso!');
    carregarProdutos();
  } catch (erro) {
    mostrarMensagem(erro.message, false);
  }
});

carregarProdutos();
