<template>
  <div class="BuscarCarro">
    <h1>
        Busca por ID
    </h1>
    
    <br/>
    <p/>
    {{carro.id}}
    {{carro.nome}}
    <br/>
    {{carro.marca}}
    <br/>
    {{carro.anoFabricacao}}
    <br/>
    {{carro.anoModelo}}
    <br/>
    {{carro.dataVenda}}
  </div>
  
</template>

<script>
export default {
    name: 'BuscarCarro',
    props: ["id"],
    data: function (){
        return{
            
            carro: {},
            baseURI: "http://localhost:8080/server/api/carros"
        }
    }, 
    created: function() {
             this.$http
             .get(this.baseURI + "/" + this.id)
             .then((result) => {
                this.carro = result.data;
            })
            .catch(function(error) {
                console.log(error);
            });
    },
}
</script>

<style>
</style>