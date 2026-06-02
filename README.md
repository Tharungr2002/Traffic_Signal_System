Step 1: Clarify Requirements
Functional Requirements:
The system should control traffic signals at a single intersection (4 traffic lights as a unit).
The system should manage automatic cycling through phases (NORTH → EAST → SOUTH → WEST).
The system should handle emergency vehicle priority requests by pausing the automatic cycle.
During emergency: All signals turn RED, emergency direction gets GREEN, then resume cycle from pause.
The system should track vehicle count at each approach.
The system should prevent conflicting signals from being active simultaneously.
The system should have configurable signal durations (RED, YELLOW, GREEN) for each direction.
The system should allow dynamic adjustment of signal durations based on traffic conditions.

Interview Tip: Always ask the interviewer to confirm the requirements before jumping into code. It shows clarity and alignment.

Non-Functional Requirements
The system should respond to user actions within reasonable time.
The system should have proper state transitions.
The system should be scalable to multiple intersections.

Edge Cases to Consider
Emergency vehicle request during signal change.
Invalid signal state transitions (handled by State Pattern).
Cycle pause/resume during emergency.

Step 2: Identify Code Entities
1. Intersection (Core Entity)
id: int [PK]
name: String
trafficLights: TrafficLight[] (4 lights: NORTH, SOUTH, EAST, WEST)
isEmergencyMode: boolean
emergencyDirection: Direction (nullable)
isCyclePaused: boolean
2. IntersectionCycle
intersectionId: int [FK]
currentPhase: int (0=NORTH, 1=EAST, 2=SOUTH, 3=WEST)
isPaused: boolean
pausedAtPhase: int
phaseStartTime: long (timestamp)
3. TrafficLight
direction: Enum (NORTH, SOUTH, EAST, WEST)
currentState: TrafficLightState (State Pattern implementation)
Consider the following transitions in TrafficLight:
Valid Transitions: RED → GREEN → YELLOW → RED
Invalid Transitions: RED → YELLOW, GREEN → RED (blocked by state pattern)
4. SignalTiming
intersectionId: int [FK]
direction: Enum (NORTH, SOUTH, EAST, WEST)
greenDuration: int (seconds)
isDynamic: boolean (for traffic-based adjustment)
yellowDuration is a constant (3 seconds) for safety
5. VehicleCounter
direction: Enum (NORTH, SOUTH, EAST, WEST)
count: int
lastUpdate: long (timestamp)
6. EmergencyRequest
id: int [PK]
intersectionId: int [FK]
direction: Enum (NORTH, SOUTH, EAST, WEST)
duration: int (seconds)
isActive: boolean
7. TrafficLightState
State interface for traffic light state management
8. RedState
Concrete state for RED traffic light
9. GreenState
Concrete state for GREEN traffic light
10. YellowState
Concrete state for YELLOW traffic light
11. OffState
Concrete state for OFF traffic light

Interview Tip: Clearly defining entities with their attributes early in the design helps you map relationships, enforce rules (like valid state transitions), and implement patterns like State Pattern more effectively.

Step 3: Visualize Interaction Flows
1. Intersection Management Flows:
Intersection Creation Flow:
Create intersection → Initialize 4 traffic lights → Set default signal timings → Start automatic cycle
Intersection Status Flow:
Request status → Return all signal states, cycle info, and current timings

2. Automatic Cycle Management Flows:
Normal Cycle Flow:
Cycle through phases: NORTH → EAST → SOUTH → WEST
Each phase: GREEN (configurable duration) → YELLOW (configurable duration) → RED → Next phase
State Pattern ensures valid transitions: RED → GREEN → YELLOW → RED
Cycle Pause/Resume Flow:
Pause cycle → Remember current phase → Resume from same phase

3. Signal Timing Management Flows:
Timing Configuration Flow:
Set signal timing → Update SignalTiming for direction → Apply to next cycle
Dynamic Timing Adjustment Flow:
Traffic condition detected → Calculate optimal timing → Update SignalTiming → Apply immediately or next cycle

4. Emergency Management Flows:
Emergency Request Flow:
Emergency request → PAUSE cycle → ALL signals transition to RED (following proper state sequence) → Emergency direction GREEN → Wait duration → Resume cycle from pause
Emergency End Flow:
End emergency → All signals transition to RED (following proper state sequence) → Resume cycle from paused phase

5. Vehicle Counting Flows:
Count Update Flow:
Vehicle detected → Update count for direction → Trigger dynamic timing adjustment if enabled (in future)
Count Query Flow:
Request count → Return vehicle count for direction

6. State Transition Flows:
Valid State Transition Flow:
TrafficLight.turnGreen() → currentState.turnGreen(this) → setState(new GreenState())
Invalid State Transition Flow:
TrafficLight.turnYellow() → currentState.turnYellow(this) → throws InvalidStateTransitionException
Emergency State Transition Flow:
Emergency transition → Check current state → Follow proper sequence (GREEN → YELLOW → RED) → Handle each state appropriately → Log transition sequence
