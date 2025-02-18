<template>
    <div>
        <String label="UserId" v-model="value.userId" :editMode="editMode"/>
        <UserCredential offline label="사용자 자격 증명" v-model="value.userCredential" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
