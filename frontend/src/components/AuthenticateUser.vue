<template>

    <v-card outlined>
        <v-card-title>
            AuthenticateUser
        </v-card-title>

        <v-card-text>
            <String label="Username" v-model="value.username" :editMode="editMode"/>
            <String label="Password" v-model="value.password" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="authenticateUser"
            >
                AuthenticateUser
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'AuthenticateUserCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.username = '';
        this.value.password = '';
    },
    watch: {
    },
    methods: {
        authenticateUser() {
            this.$emit('authenticateUser', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

