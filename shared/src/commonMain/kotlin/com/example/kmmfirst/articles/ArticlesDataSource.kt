package com.example.kmmfirst.articles

import com.example.kmmfirst.db.Article
import com.example.kmmfirst.db.KMMFirstDatabase

class ArticlesDataSource(private val database: KMMFirstDatabase) {
    fun getAllArticles() : List<ArticleRaw> = database.kMMDatabaseQueries.selectAllArticles(::mapToArticleRow).executeAsList()

    fun insertArticles(articles:List<ArticleRaw>){
        // transaction means all a queries should success to return true and must happen all together
        database.kMMDatabaseQueries.transaction {
            articles.forEach {
                insertArticle(it)
            }
        }
    }


    fun clearArticles() =
        database.kMMDatabaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticleRaw) {
        database.kMMDatabaseQueries.insertArticle(
            article.title,
            article.desc,
            article.date,
            article.imageUrl
        )
    }

    private fun mapToArticleRow(
        title:String,
        desc:String?,
        date:String,
        image:String?
    ) :ArticleRaw = ArticleRaw(title,desc,date,image)
}