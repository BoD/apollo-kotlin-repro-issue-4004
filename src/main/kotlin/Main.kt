import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.MyMutation


suspend fun main() {
    val apolloClient = ApolloClient.Builder()
        .serverUrl("http://localhost:4000/graphql")
        .build()

    val response = apolloClient.mutation(MyMutation(lastName = "")).execute()
    println(response.toFormattedString())
}

private fun ApolloResponse<*>.toFormattedString(): String {
    return "ApolloResponse(errors=$errors, data=$data)"
}
