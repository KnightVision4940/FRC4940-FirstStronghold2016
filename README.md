#**FIRST Stronghold** |  KnightVision Robotics 4940

:four::nine::four::zero:

[![wercker status](https://app.wercker.com/status/24e500e6723b88a82070ea0f84a57d6a/s "wercker status")](https://app.wercker.com/project/bykey/24e500e6723b88a82070ea0f84a57d6a)

[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/hyperium/hyper/master/LICENSE)

[![forthebadge](http://forthebadge.com/images/badges/designed-in-ms-paint.svg)](http://forthebadge.com)

###About
  This is the code for FRC team 4940, **KnightVision Robotics**, for the 2016 FRC Season.
  This year's game is [FIRST Stronghold](http://www.firstinspires.org/sites/default/files/uploads/resource_library/frc/first-stronghold-game-onepage.pdf).
 
##Robot Features

####SubSystems

  + Drive train. 4 PWM Victors, driving AndyMark rhino tracks
  + Arm. Contains two smaller subsystems: main arm and ballscrew.
    Main arm controls arm rotation, and ballscrew controls arm length.
    Run with 1 CAN TalonSRX and 1 encoder each.

####Features

  + BoundBox Algorithm. Ensures the robot never extends 15 inches past frame perimeter or 54 inches above the ground.
     This is disabled once arm goes pat 85 degrees, as to allow for scaling
 + 4 working autonomous modes. Low Bar, Ramparts, Moat, and Rough Terrain
   Auto mode is selected through SmartDashboard; recompiling is not needed.
 + Xbox Controller is used to drive the robot.
