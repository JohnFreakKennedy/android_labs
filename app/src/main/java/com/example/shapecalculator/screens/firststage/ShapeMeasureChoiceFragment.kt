package com.example.shapecalculator.screens.firststage

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import android.net.Uri
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.example.shapecalculator.R
import com.example.shapecalculator.databinding.ActivityCalculationBinding
import com.example.shapecalculator.databinding.FragmentChoiceBinding
import com.example.shapecalculator.screens.secondstage.CalculationActivity


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ShapeMeasureChoiceFragment : Fragment() {

    private var _binding: FragmentChoiceBinding? = null
    private val binding get() = _binding!!

    private lateinit var calculateButton: Button
    private lateinit var checkBoxArea: CheckBox
    private lateinit var checkBoxPerimeter: CheckBox
    private lateinit var radioGroupShapes: RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calculateButton = binding.selectedShapeNextButton
        checkBoxArea = binding.checkboxArea
        checkBoxPerimeter = binding.checkboxPerimeter
        radioGroupShapes = binding.shapesRadioGroup

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val buttonColorDrawable = calculateButton.background as? ColorDrawable
        var buttonColor = buttonColorDrawable?.color
        if (buttonColor == null) buttonColor = Color.BLUE

        calculateButton.isEnabled = false
        calculateButton.setBackgroundColor(Color.GRAY)

        val radioButtons = arrayOf(
            binding.radioButtonTriangle,
            binding.radioButtonCircle,
            binding.radioButtonSquare,
            binding.radioButtonRectangle,
            binding.radioButtonParallelogram,
            binding.radioButtonTrapezium
        )

        for (radioButton in radioButtons) {
            radioButton.setOnCheckedChangeListener { _, isChecked ->
                updateButtonState()
            }
        }

        checkBoxArea.setOnCheckedChangeListener { _, isChecked ->
            updateButtonState()
        }

        checkBoxPerimeter.setOnCheckedChangeListener { _, isChecked ->
            updateButtonState()
        }

            calculateButton.setOnClickListener {
                if (!calculateButton.isEnabled) {
                    showNotSelectedToast("Please, select a type of measure to calculate!")
                }
                else {
                    val shapeId = radioGroupShapes.checkedRadioButtonId
                    val intent = Intent(requireContext(), CalculationActivity::class.java)
                    when (shapeId) {
                        R.id.radioButtonCircle -> intent.putExtra("shape", "circle")
                        R.id.radioButtonParallelogram -> intent.putExtra("shape", "parallelogram")
                        R.id.radioButtonRectangle -> intent.putExtra("shape", "rectangle")
                        R.id.radioButtonSquare -> intent.putExtra("shape", "square")
                        R.id.radioButtonTrapezium -> intent.putExtra("shape", "trapezium")
                        R.id.radioButtonTriangle -> intent.putExtra("shape", "triangle")
                    }
                    val checkArea:Boolean = checkBoxArea.isChecked
                    val checkPerimeter:Boolean = checkBoxPerimeter.isChecked
                    intent.putExtra("isAreaChecked", checkArea)
                    intent.putExtra("isPerimeterChecked", checkPerimeter)

                    startActivity(intent)
                }
            }
    }


    private fun updateButtonState() {
        val isCheckBoxAreaChecked = checkBoxArea.isChecked
        val isCheckBoxPerimeterChecked = checkBoxPerimeter.isChecked
        val isRadioButtonSelected = radioGroupShapes.checkedRadioButtonId != -1

        if(isRadioButtonSelected && (isCheckBoxAreaChecked || isCheckBoxPerimeterChecked)) {
            calculateButton.isEnabled = true
            calculateButton.setBackgroundColor(Color.BLUE)
        }
        else {
            calculateButton.isEnabled = false
            calculateButton.setBackgroundColor(Color.GRAY)
        }
    }

    private fun showNotSelectedToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
