package br.com.jvdc

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jvdc.navigation.AppRoutes
import br.com.jvdc.ui.movies.MoviesListRoute
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = AppRoutes.MoviesList){
            composable<AppRoutes.MoviesList>{
                MoviesListRoute()
            }
            composable<AppRoutes.MovieDetails>{

            }

        }
    }
}