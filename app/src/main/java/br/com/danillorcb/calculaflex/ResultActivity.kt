package br.com.danillorcb.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.danillorcb.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        calculate()
    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE", 0.0)
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE", 0.0)

        val performanceMyCar = ethanolAverage / gasAverage
        val priceOfIndice = ethanolPrice / gasPrice

        if (priceOfIndice <= performanceMyCar) {
            tvSuggestion.text = getString(R.string.ethanol)
        } else {
            tvSuggestion.text = getString(R.string.gasoline)
        }

        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)
    }
}
