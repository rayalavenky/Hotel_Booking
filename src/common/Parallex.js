import React from 'react'
import { Container } from 'react-bootstrap'

const Parallex = () => {
  return (
    <div className="parallex mb-5">
      <Container className='text-center px-5 py-5 justify-content-center'>
        <div className='animated-texts bouceIn'>
          <h1>
            Welcome to <span className="hotel-color">Hotel</span>
          </h1>
          <h3>We offer the best services for all your needs</h3>
        </div>
      </Container>
    </div>
  );
}

export default Parallex
