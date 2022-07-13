package com.test.multitab.ui.navigation.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.multitab.data.entities.User

import com.test.multitab.ui.viewmodels.MainActivityViewModel


@Composable
fun CreateUserScreen(
    navController: NavController,
    modifier: Modifier = Modifier ,
    viewModel: MainActivityViewModel = hiltViewModel(),
) {
    val isUserCreatedState: State<Boolean> = viewModel.userCreateState.collectAsState()

    val context = LocalContext.current
    if (isUserCreatedState.value){
        Toast.makeText(context,"user created",Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    Column {

        var name by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = "Name")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )

        var email by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )



        var gender by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = gender,
            onValueChange = {
                gender = it
            },
            label = {
                Text(text = "Gender")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )

        // Declaring a boolean value to store
        // the expanded state of the Text Field
        var mExpanded by remember { mutableStateOf(false) }

        // Create a list of cities
        val mCities = listOf("active","inactive")

        // Create a string value to store the selected city
        var mSelectedText by remember { mutableStateOf("") }

        var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(modifier.padding(20.dp)) {

            // Create an Outlined Text Field
            // with icon and not expanded
            OutlinedTextField(
                value = mSelectedText,
                enabled = false,
                onValueChange = { mSelectedText = it },
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Status") },
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        modifier.clickable { mExpanded = !mExpanded })
                }
            )

            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
                modifier = modifier
                    .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
            ) {
                mCities.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedText = label
                        mExpanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }

            Spacer(modifier = modifier.padding(10.dp))

           Box(
               modifier = modifier.fillMaxWidth(),
               contentAlignment = Alignment.Center
           ) {
               Button(
                   onClick = {
                             viewModel.createUser(User(
                                 name = name,
                                 email = email,
                                 gender = gender,
                                 status = mSelectedText
                             ))

                   },
               ) {
                   Text(text = "Create" )
               }
           }
        }
    }


}

@Preview
@Composable
fun Preview() {
   //CreateUserScreen()
}
