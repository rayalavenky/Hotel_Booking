import React from 'react'
import MainHeader from '../layout/MainHeader'
import HotelService from '../common/HotelService'
import Parallex from '../common/Parallex'
import RoomCarousel from '../common/RoomCarousel'
import RoomSearch from '../common/RoomSearch'
import { useLocation } from 'react-router-dom'

const Home = () => {
  const location = useLocation()
  const message = location.state && location.state.message
  const currentUser = localStorage.getItem("userId")
  return (
    <section>
      {message && <p className='text-warning px-5'>{message}</p>}
      <MainHeader />
      <section className="container">
        <RoomSearch />
        <RoomCarousel/>
        <Parallex />
        <RoomCarousel/>
        <HotelService />
        <Parallex />
        <RoomCarousel/>
      </section>
    </section>
  );
}

export default Home
