#version 150

out vec4 fragColour;

uniform float Time;

void main() {
    vec2 resolution = vec2(256, 256);
    vec2 st = gl_FragCoord.xy / resolution.xy;
    st.x *= resolution.x / resolution.y;

    vec3 color = vec3(0.0);
    color = vec3(st.x, st.y, abs(sin(Time)));

    fragColour = vec4(color, 1.0);
}
