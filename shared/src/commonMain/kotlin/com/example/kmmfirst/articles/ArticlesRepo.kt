package com.example.kmmfirst.articles

class ArticlesRepo(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles():List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()

        println("${articlesDb.size}")

        if (articlesDb.isEmpty()){
            val fetchedArticles= service.fetchArticles()
            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDb
    }
}