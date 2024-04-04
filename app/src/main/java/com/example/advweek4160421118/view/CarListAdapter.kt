package com.example.advweek4160421118.view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421118.databinding.CarListItemBinding
import com.example.advweek4160421118.model.Car



class CarListAdapter  (val carList:ArrayList<Car>)
    : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    class CarViewHolder(var binding: CarListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)

    }
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binding.txtID.text = carList[position].id.toString()
        holder.binding.txtName.text = carList[position].name
        holder.binding.txtManufactur.text = carList[position].manufacturer.toString()
        holder.binding.txtYear.text= carList[position].year.toString()
        holder.binding.txtColor.text = carList[position].color
        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }


    fun updateStudentList(newCarList: ArrayList<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }



}