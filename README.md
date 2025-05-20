# Sistema de Gerenciamento UCS - P.I_SV-III-B

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-brightgreen.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

## 📋 Descrição

Sistema desktop para gerenciamento de vendas, produtos e usuários, desenvolvido em Java (Swing) com persistência em banco de dados relacional (MySQL ou PostgreSQL). Projeto acadêmico UCS.

Repositório oficial: [https://github.com/ALN2025/P.I_SV-III-B](https://github.com/ALN2025/P.I_SV-III-B)

---

## 🚀 Funcionalidades

- Cadastro de usuários
- Cadastro de produtos
- Registro de vendas
- Registro de itens de venda
- Extrato de vendas (quem vendeu, o que vendeu, quantidade, preço)
- Interface gráfica moderna e responsiva

---

## 🏗️ Arquitetura

- **MVC Simplificado:**  
  - View: Telas Swing  
  - Model: Classes de domínio  
  - DAO: Persistência e acesso ao banco
- **Banco de Dados Relacional:**  
  - Tabelas: usuários, produtos, vendas, itens_venda
- **Build:** Maven

---

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── sistema/
│   │           ├── dao/
│   │           ├── model/
│   │           ├── view/
│   │           └── util/
│   └── resources/
│       ├── script.sql
│       └── [imagens]
└── test/
```

---

## ⚙️ Requisitos

- Java JDK 17 ou superior
- MySQL 8+ (ou PostgreSQL, se adaptado)
- Maven 3.6+
- VSCode ou Eclipse

---

## 🛠️ Instalação e Execução

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/ALN2025/P.I_SV-III-B.git
   cd P.I_SV-III-B
   ```

2. **Configure o banco de dados:**
   - Crie o banco e as tabelas executando `src/main/resources/script.sql` no seu SGBD.
   - Ajuste as credenciais de acesso no arquivo de conexão (`ConexaoBD.java`).

3. **Compile o projeto:**
   ```sh
   mvn clean package
   ```

4. **Execute o sistema:**
   - Pelo terminal:
     ```sh
     java -jar target/sistema-gerenciamento-1.0-SNAPSHOT-jar-with-dependencies.jar
     ```
   - Ou pelo arquivo `iniciar.bat`.

---

## 🖥️ Telas do Sistema

- Tela Principal
- Cadastro de Usuário
- Cadastro de Produto
- Cadastro de Venda
- Cadastro de Item de Venda (com extrato)
- [Adicione prints das telas aqui]

---

## 🧩 Tecnologias Utilizadas

- Java (Swing)
- MySQL (ou PostgreSQL)
- Maven
- JDBC
- Padrão DAO

---

## 💡 Propostas de Evolução

- Suporte a múltiplos SGBDs (MySQL/PostgreSQL) via padrão Strategy
- Paginação nas tabelas de dados
- ComboBox para seleção de vendas/produtos
- Filtros e ordenação nas tabelas
- Interface gráfica aprimorada

---

## 🤝 Contribuição

1. Fork este repositório
2. Crie uma branch: `git checkout -b feature/sua-feature`
3. Commit suas alterações: `git commit -m 'feat: Minha nova feature'`
4. Push para a branch: `git push origin feature/sua-feature`
5. Abra um Pull Request

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👤 Autor

- [ALN2025 (Anderson Nascimento)](https://github.com/ALN2025)
- Projeto acadêmico UCS - Caxias do Sul/RS

---

> Para dúvidas, sugestões ou colaborações, abra uma issue ou entre em contato pelo [GitHub](https://github.com/ALN2025). 