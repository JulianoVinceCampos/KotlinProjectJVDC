package br.com.jvdc

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import br.com.jvdc.di.dataModule
import br.com.jvdc.di.networkModule
import br.com.jvdc.di.viewModelModule
import br.com.jvdc.navigation.AppRoutes
import br.com.jvdc.ui.moviedetail.MovieDetailRoute
import br.com.jvdc.ui.movies.MoviesListRoute
import br.com.jvdc.ui.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication


@Composable
@Preview
fun App() {
    KoinApplication(
            application = {
                modules(networkModule, dataModule, viewModelModule)
            }
    ){
        MoviesAppTheme {
          val navController = rememberNavController()
          NavHost(navController, startDestination = AppRoutes.MoviesList){
              composable<AppRoutes.MoviesList>{
                  MoviesListRoute(
                      navigateToMovieDetail =  { movieId ->
                          navController.navigate(AppRoutes.MovieDetail(movieId))
                      }
                  )
              }
              composable<AppRoutes.MovieDetail>{
                  MovieDetailRoute(
                      navigationBack = {
                          navController.popBackStack()
                      }
                  )
              }

          }
      }
    }
}