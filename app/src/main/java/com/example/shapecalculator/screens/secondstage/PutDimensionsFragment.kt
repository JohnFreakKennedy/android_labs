package com.example.shapecalculator.screens.secondstage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shapecalculator.R
import com.example.shapecalculator.databinding.FragmentPutDimensionsCircleBinding
import com.example.shapecalculator.databinding.FragmentPutDimensionsGeneralBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PutDimensionsFragment : Fragment() {

    private var _binding: FragmentPutDimensionsCircleBinding? = null
    private val selectedShapeType: String? = arguments?.getString("shape")
    private val checkedArea: Boolean? = arguments?.getBoolean("checkArea")
    private val checkedPerimeter: Boolean? = arguments?.getBoolean("checkPerimeter")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPutDimensionsCircleBinding.inflate(inflater, container, false)
        val shapeType = arguments?.getString("shapeType")
        val layoutId = when (selectedShapeType) {
            "circle" -> R.layout.fragment_put_dimensions_circle
            "square" -> R.layout.fragment_put_dimensions_square
            "rectangle" -> R.layout.fragment_put_dimensions_rectangle
            "triangle" -> R.layout.fragment_put_dimensions_triangle
            "parallelogram" -> R.layout.fragment_put_dimensions_parallelogram
            "trapezium" -> R.layout.fragment_put_dimensions_trapezium
            // Add more cases for other shape types
            else -> R.layout.content_calculation
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_PutDimensionsFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}