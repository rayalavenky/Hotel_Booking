import React from 'react'
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "/node_modules/bootstrap/dist/js/bootstrap.min.js"
import AddRoom from './room/AddRoom'
import ExistingRooms from './room/ExistingRooms'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './home/Home'
import EditRoom from './room/EditRoom'
import Footer from './layout/Footer'
import NavBar from './layout/NavBar'
import RoomListing from './room/RoomListing'
import Admin from './admin/Admin'
import Checkout from './bookings/Checkout'
import BookingSuccess from './bookings/BookingSuccess'
import Bookings from './bookings/Bookings'
import FindBooking from './bookings/FindBooking'
import Login from './auth/Login'
import Registration from './auth/Registration'
import Profile from './auth/Profile'
import Logout from './auth/Logout'
import {AuthProvider} from './auth/AuthProvider'
import RequireAuth from './auth/RequireAuth'


function App() {
  return (
    <AuthProvider>
    <main>
      <Router>
        <NavBar/>
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/edit-room/:roomId' element={<EditRoom/>}/>
          <Route path='/existing-rooms' element={<ExistingRooms/>}/> 
          <Route path='/add-room' element={<AddRoom/>}/> 

          <Route
							path="/book-room/:roomId"
							element={
								<RequireAuth>
									<Checkout />
								</RequireAuth>
							}
						/>


          <Route path='/browse-all-rooms' element={<RoomListing/>}/> 
          <Route path='/admin' element={<Admin/>}/> 
          <Route path='/booking-success' element={<BookingSuccess/>}/>
          <Route path='/existing-bookings' element={<Bookings/>}/>
          <Route path='/find-booking' element={<FindBooking/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/register' element={<Registration/>}/>
          <Route path='/profile' element={<Profile/>}/>
          <Route path='/logout' element={<Logout/>}/>


        </Routes>
      </Router>
      <Footer/>
    </main>
    </AuthProvider>
  )
}

export default App
