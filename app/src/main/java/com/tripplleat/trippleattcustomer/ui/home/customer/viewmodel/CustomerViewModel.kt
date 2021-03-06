package com.tripplleat.trippleattcustomer.ui.home.customer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tripplleat.trippleattcustomer.modal.Variant
import com.tripplleat.trippleattcustomer.modal.VariantLoose
import com.tripplleat.trippleattcustomer.modal.VariantSeller
import com.tripplleat.trippleattcustomer.modal.VariantSellerLoose
import com.tripplleat.trippleattcustomer.repo.CustomerRepo
import com.tripplleat.trippleattcustomer.ui.home.customer.modal.ProductDetails
import com.tripplleat.trippleattcustomer.ui.home.customer.modal.StoreDetails

class CustomerViewModel(private val repo : CustomerRepo, private val application : Application) : ViewModel() {

    //homefragment variables
    var storesList = MutableLiveData<List<StoreDetails>>()
    var start: Int = 0
    var currentStore : StoreDetails? = null

    //Products Fragment Variable
    var productName : String ? = null
    var _productList  = MutableLiveData<List<String>>()
    var _PackedProductSeller = MutableLiveData<HashMap<String,ArrayList<VariantSeller>>>()
    var _looseProductSeller = MutableLiveData<HashMap<String,ArrayList<VariantSellerLoose>>>()
    var _packedProductMain = MutableLiveData<HashMap<String,Variant>>()
    var _looseProductMain = MutableLiveData<HashMap<String,VariantLoose>>()
    var isProductAddedToCart = MutableLiveData<Int>()
    var currentVariant = HashMap<Int,ProductDetails>()
    var currentCartList = ArrayList<ProductDetails>()

    //Cart Fragment Variable
    var isListLoaded  = false
    var isChangesDone = MutableLiveData<Int>()
    var _ProductsInCart = MutableLiveData<ArrayList<ProductDetails>>()

    init {
        currentVariant.put(-1,ProductDetails("fake","fake","fake",-1,-1,-1,-1,"fake",0,"fake","fake","fake","fake","fake"))
        repo.fetchProductsInCart(_ProductsInCart,currentCartList)
        repo.fetchAllStores(storesList)
    }

    //function to fetch product from sellers
    fun fetchProductList() {
        if(currentStore != null){
            Log.i("store_product","${currentStore!!.id}")
            repo.fetchAllProduct(currentStore!!.id,_productList,_PackedProductSeller,_looseProductSeller)
        }
        else
            Log.i("store_product","empty current store")
    }

    //function to fetch packed and loose variant of a particular shop
    fun fetchPackedAndLooseVariant(){
        repo.fetchLooseVariants(_looseProductMain,_looseProductSeller, _productList)
        repo.fetchPackedVariants(_packedProductMain,_PackedProductSeller,_productList)
    }

    //function to add product in cart
    fun addProductTocart(product: ProductDetails) {
        product.sellerId = currentStore?.id!!
        product.shopName = currentStore?.shopName!!
        repo.addProductTocart(product,isProductAddedToCart)
    }

    //function to remove product from cart
    fun removeProductFormCart(product: ProductDetails) {
        repo.removeProductFromCart(product,isChangesDone)
    }

    //function to update a product present inside cart
    fun updateProdutcInCart(product: ProductDetails) {
        repo.updateProductIncart(product,isChangesDone)
    }


}