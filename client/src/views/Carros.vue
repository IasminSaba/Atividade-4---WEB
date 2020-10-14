<template>

<div class="carros">
  <ul>
      <li v-for="carro in carros" :key="carro.id">
        <div id="geral">
          <div class="left">
            <h4>ID:{{ carro.id }}</h4>
            <p> Nome: {{ carro.nome }}</p>
            <p> Marca: {{ carro.marca }}</p>
            <p> Ano de Fabricação: {{ carro.anoFabricacao }}</p>
            <p> Ano do Modelo: {{ carro.anoModelo }}</p>
            <p> Data de Venda: {{ carro.dataVenda }}</p>
          </div>
         
        </div>
        <hr />
      </li>
    </ul>

</div>
</template>

<script>
export default {
  name: 'Carros',
  data() {
    return {
      carros: [],
      baseURI:  "http://localhost:8080/server/api/carros"
    };
  },

  created: function() {
    this.getAll();
  },

  methods: {
    getAll: function() {
      this.$http.get(this.baseURI).then(result => {
        this.carros = result.data;
      });
    },
    deleteUserById: function(id) {
      this.$http.delete(this.baseURI + "/" + id).then(result => {
        this.getAll();
      });
    }
  }
};
</script>

<style>
</style>