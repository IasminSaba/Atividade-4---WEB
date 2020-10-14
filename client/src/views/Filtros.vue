<template>
  <div class="filtros">
    <h1> Filtros</h1>

    <h3> Digite a quantidade de registros que deseja recuperar</h3>
    <input type="text" v-model="numRegistros" />
    <br />  <p> </p>
    <button @click="getByNumRegistros">Buscar</button>

    <h3> Digite a marca que deseja buscar</h3>
    <input type="text" v-model="marca" />
    <br />  <p> </p>
    <button @click="getByMarca">Buscar</button>
    
    <ul>
      <li v-for="carro in carrosFiltrados" :key="carro.id">
        <div id="geral">
          <div class="left">
            <h4>{{ carro.id }}</h4>
            <p>{{ carro.nome }}</p>
            <p>{{ carro.marca }}</p>
          </div>
         
        </div>
        <hr />
      </li>
    </ul>

  </div>
</template>

<script>
export default {
    name: "Filtros",
    data: function() {
        return{
            carrosFiltrados: [],
            marca: "",
            numRegistros: "",
            baseURI: "http://localhost:8080/server/api/carros"
        }
    },
    methods: {
        getByMarca: function (){
            this.$http
             .get(this.baseURI + "?marca=" + this.marca)
             .then((result) => {
                this.carrosFiltrados = result.data;

            })
            .catch(function(error) {
                console.log(error);
            });
        },
        
        getByNumRegistros: function (){
            this.$http
             .get(this.baseURI + "?numRegistros=" + this.numRegistros)
             .then((result) => {
                this.carrosFiltrados = result.data;

            })
            .catch(function(error) {
                console.log(error);
            });
        }
    }
}
</script>

<style>

</style>