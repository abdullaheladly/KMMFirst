package com.example.kmmfirst.articles

class ArticlesRepo(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(forceFetch:Boolean):List<ArticleRaw> {

        if (forceFetch){
            println("in")

            dataSource.clearArticles()
           return fetchArticles()
        }else {
            val articlesDb = dataSource.getAllArticles()

            println("${articlesDb.size}")

            if (articlesDb.isEmpty()) {
                fetchArticles()
            }
            return articlesDb
        }
    }

    private suspend fun fetchArticles() : List<ArticleRaw> {
        val fetchedArticles= service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        println("${fetchedArticles.size}")
        return fetchedArticles
    }
}