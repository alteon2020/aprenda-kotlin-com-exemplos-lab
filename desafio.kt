// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val id: Int, val username: String, var firstName: String?, var lastName: String?, val level: Nivel)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val basico1 = ConteudoEducacional("Instalar o kotlin", 10);
    val basico2 = ConteudoEducacional("Criar um projeto sprint para o kotlin no playground", 10);
    val basico3 = ConteudoEducacional("Escrever os endpoints da primeira aplicação", 10);
    
    val inter1 = ConteudoEducacional("Integrar o banco de dados postgres", 20);
    val inter2 = ConteudoEducacional("Modelar as classes de integração com o banco", 20);
    
    val avan1 = ConteudoEducacional("Melhorar a performance das aplicações", 30);
    val avan2 = ConteudoEducacional("Deixar a aplicação no padrão mvc", 30);
    val avan3 = ConteudoEducacional("Fazer deploy da aplicação", 20);
    
    val contentB = listOf(basico1, basico2, basico3);
    val contentI = listOf(inter1, inter2);
    val contentA = listOf(avan1, avan2, avan3);
    
    val user1 = Usuario(1, "JoseM", "Jose", "de Mascarenhas", Nivel.BASICO);
    val user2 = Usuario(1, "JoseT", "Jose", "de Tiego", Nivel.INTERMEDIARIO);
    val user3 = Usuario(1, "JoseA", "Jose", "Alberto", Nivel.AVANCADO);
    
    val basico = Formacao("basico", contentB);
    val inter = Formacao("intermediario", contentI);
    val avancado = Formacao("avancado", contentA);
    
    for (user in listOf(user1, user2, user3)) {
        when(user.level){
            Nivel.BASICO -> basico.matricular(user)
            Nivel.INTERMEDIARIO -> inter.matricular(user)
            Nivel.AVANCADO -> avancado.matricular(user)
        }
    }
    
    for (formacao in listOf(basico, inter, avancado)) println("Existem ${formacao.inscritos.count()} no nivel ${formacao.nome.uppercase()}")
}
