package com.example.agribizz

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.agribizz.databinding.ActivitySupplierMapsBinding
import com.google.android.gms.maps.model.Marker

class SupplierMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivitySupplierMapsBinding
         //the default location- when te map launches we have an area where the map focuses on
         var MyPlace = LatLng(48.73, -73.99)
     // a string location- we will convert the string/location to a longitude and a latitude
         var longitude= -73.99
         var latitude= 48.73

      //new pin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySupplierMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //setonclick listener for button here
        binding.find.setOnClickListener{





            //the commented codes below are of an edit text in the file where the user inputs data
            //the id of the edit text is id


           // var location: String = binding.location.text.toString() //get user input
            //Toast.makeText(this,"Goods Found:"+ location, Toast.LENGTH_SHORT).show()

       //var convertedlatlng :String= getLocationFromAddress(location)

            //splitting the coordinate
           // var spliththecoordinate= convertedlatlng.split(",").toTypedArray()

        //store the latitude and the longitude
        //    latitude = spliththecoordinate[0].toDouble()
        //    longitude = spliththecoordinate[1].toDouble()

            MyPlace = LatLng(latitude, longitude)


            //place the new marker
            val markerName= mMap.addMarker(MarkerOptions().position(MyPlace).title("Goods Here"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MyPlace, 18f))


        }



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(MyPlace).title("Goods Here"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MyPlace, 18f))

    }
    fun getLocationFromAddress(strAddress: String?): String{
        val coder = Geocoder(this)
        //empty list with address
        val addresses: List<Address>?

        return try {
            //convert the string to a latitude and a longitude
            addresses = coder.getFromLocationName(strAddress, 1)
            //if nothing was found
            if (addresses == null){
                return "0,0"
            }
            val address = addresses[0]
            val lat = address.latitude
            val lng = address.longitude
            val location : String ="$lat,$lng"
            return location
        }
        catch (e: Exception){
            "0,0"
        }
    }


}
