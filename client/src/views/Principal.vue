<template>
  <div class="principal">
    <h1>Cadastro</h1>
    <h3>Nome:</h3>
    <input type="text" name id="nome" v-model="nome" />
    <br />

    <h3>Marca:</h3>
    <input type="text" name id="marca" v-model="marca" />
    <br />

    <h3>Ano de Fabricação:</h3>
    <input type="text" name id="anoFabricacao" v-model="anoFabricacao" />
    <br />

    <h3>Ano do modelo:</h3>
    <input type="text" name id="anoModelo" v-model="anoModelo" />
    <br />

    <h3>Data de Venda:</h3>
    <input type="text" name id="dataVenda" v-model="dataVenda" />
    
    <br />   <br /> <br />

    <button @click="insertCarro">Cadastrar</button>

    <br />    <p> </p> 
    
    <button @click="getAll">Listar</button>

    <h3>Campo id para busca, deleção e atualizações</h3>
    <h3>ID</h3>
    <input type="text" v-model="id" />

    <br />  <p> </p>
    <button @click="getRegistro">Buscar</button>

    <br />  <p> </p>
    <button @click="update">Update</button>

    <br />  <p> </p>
    <button @click="deleteById">Delete</button>
  </div>
</template>

<script>
export default {
  name: 'Principal',
  
  data: function() {
    return {
      id: "",
      carro: {},
      carros: [],
      nome: "",
      marca: "",
      anoFabricacao: "",
      anoModelo: "",
      dataVenda: "",
      baseURI: "http://localhost:8080/server/api/carros"
    };
  },
  methods: {
    insertCarro: function() {
      let obj = {
        nome: this.nome,
        marca: this.marca,
        anoFabricacao: this.anoFabricacao,
        anoModelo: this.anoModelo,
        dataVenda: this.dataVenda,
      };

      this.$http.post(this.baseURI, obj).then(result => {
        if (result.data != "") {
         this.$router.push({ name: 'Carros'});
        }
      });
    },

    getAll: function() {
      this.$http.get(this.baseURI).then(result => {
        this.carros = result.data;
        this.$router.push({ name: 'Carros'});
      });
    },

    getRegistro: function (){
            this.$http
             .get(this.baseURI + "/" + this.id)
             .then((result) => {
                this.carro = result.data;
                alert(this.carro.id);
                this.$router.push({ name: 'BuscarCarro',  params: { id: this.carro.id } });
            })
            .catch(function(error) {
                console.log(error);
            });
    },

    update: function() {
      let obj = {
        nome: this.nome,
        marca: this.marca,
        anoFabricacao: this.anoFabricacao,
        anoModelo: this.anoModelo,
        dataVenda: this.dataVenda,
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        this.$router.push({ name: 'Carros'});
      });
    },

    deleteById: function() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        this.$router.push({ name: 'Carros'});
      });
    },
  }
};
</script>

<style>

</style>